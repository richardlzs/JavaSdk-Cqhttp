# JavaSdk-Cqhttp

使用springboot开发的，简单的go-cqhttp通信sdk.

### 通信方式

- [x] HTTP API
- [x] 反向 HTTP POST

### 支持范围
 https://docs.go-cqhttp.org/api/ 绝大多数在go-cqhttp里面实现的api


- 频道API没有实现


- 以下功能API未实现

| 功能     | 原因                    | 涉及对应文档的endpoint         |
|--------|-----------------------|-------------------------|
| 转发内容相关 | 似乎容易风控？               | send_group_forward_msg等 |
| 语音相关   | 语音需要额外安装ffmpeg，且需求不大* | get_record              |
| 在线机型相关 | 对应接口废弃                | _set_model_show         |
*：其实是我懒

### 快速上手

    1. 运行go-cqhttp，并将本代码下载到本地

    2. 配置application.yml:
        com:richard:sdk:url:<go-cqhttp正向http的地址，如http://127.0.0.1:10010/
        server.port:<go-cqhttp反向http的端口，如10010>

    3. 使用go-cqhttp的api时，请调用api.Contact类下的函数

    4. 需要接收来自go-cqhttp的反向http时,需要实现contract包下的所有接口.

### 文档
必要的说明以注释的方法“详细地”注明。函数命名已经尽量和go-cqhttp官方文档相近。有需要请参考

- API相关： https://docs.go-cqhttp.org/api/
- EVENT相关： https://docs.go-cqhttp.org/event/

    
    