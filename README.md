## wechat

### spring-boot-wechat-official-account-starter auto configuration

config in *.yml 

```
wechat:
  config:
    url: https://api.weixin.qq.com/cgi-bin/
    app-id: xxx
    secret-key: xxx
    token: xx
    aes-key: xxx
    enable-local-lock: true   
    enable-redis-store: true  ## wechat token store, default LocalTokenStore,if true please config spring redis  
```

  enable-local-lock 刷新token是否使用本地锁 可以查看 TokenExpireLock，默认为SingleInstanceLock，单个实例场景可以打开，否则使用redis分布式锁，使用redission实现。
  enable-redis-store 存储token是否使用redis 默认为LocalTokenStore，单个实例场景可以打开，否则使用redis
