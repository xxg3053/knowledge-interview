# IO模型
来自博文：https://www.cnblogs.com/myJavaEE/p/6721127.html   

四种io模型
1) 同步阻塞IO（Blocking IO）
2) 同步非阻塞IO（Non-blocking IO）
3) IO多路复用（IO Multiplexing）又成异步阻塞IO
4) 异步IO（Asynchronous IO） 

1.同步阻塞IO
最简单的IO模型，用户线程在读写时被阻塞

数据拷贝指请求到的数据先存放在内核空间, 然后从内核空间拷贝至程序的缓冲区

伪代码如下
```
{
    // read阻塞
    read(socket, buffer);
    // 处理buffer          
    process(buffer);
}
```
用户线程在IO过程中被阻塞，不能做任何事情，对CPU的资源利用率不高 

2. 同步非阻塞
用户线程不断发起IO请求. 数据未到达时系统返回一状态值; 数据到达后才真正读取数据  

伪代码如下
```
{
    // read非阻塞   
    while(read(socket, buffer) != SUCCESS);
    process(buffer);
}
```
用户线程每次请求IO都可以立即返回，但是为了拿到数据，需不断轮询，无谓地消耗了大量的CPU
一般很少直接使用这种模型，而是在其他IO模型中使用非阻塞IO这一特性

3. IO多路复用
IO多路复用建立在内核提供的阻塞函数select上

用户先将需要进行IO操作的socket添加到select中，然后等待阻塞函数select返回。当数据到达后，socket被激活，select返回，用户线程就能接着发起read请求 


伪代码如下:
```
{
    // 注册
    select(socket);
    // 轮询
    while(true) {
        // 阻塞
        sockets = select();
        // 数据到达, 解除阻塞
        for(socket in sockets) {
            if(can_read(socket)) {
            // 数据已到达, 那么socket阻不阻塞无所谓
　　　　　　　read(socket, buffer);
            process(buffer);
            }
        }
    }
}
```
看起来和加了循环的同步阻塞IO差不多?

实际上, 我们可以给select注册多个socket, 然后不断调用select读取被激活的socket，实现在同一线程内同时处理多个IO请求的效果.

至此, 同步阻塞(阻塞在select) / 同步非阻塞(IO没有阻塞) {不知道该怎么称呼}完成

更进一步, 我们把select轮询抽出来放在一个线程里, 用户线程向其注册相关socket或IO请求，等到数据到达时通知用户线程，则可以提高用户线程的CPU利用率.
这样, 便实现了异步方式


4. 异步IO  
真正的异步IO需要操作系统更强的支持。
IO多路复用模型中，数据到达内核后通知用户线程，用户线程负责从内核空间拷贝数据;
而在异步IO模型中，当用户线程收到通知时，数据已经被操作系统从内核拷贝到用户指定的缓冲区内，用户线程直接使用即可。
