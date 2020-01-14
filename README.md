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
    enable-local-lock: true   ## wechat get fresh token lock, see TokenExpireLock
    enable-redis-store: true  ## wechat token store, default LocalTokenStore,if true please config spring redis  
```
