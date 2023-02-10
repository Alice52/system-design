# API

[基本规则](https://github.com/inetfuture/technote/blob/master/restful_api.md#best-practices)

## 资源名

### 创建

- Endpoint

  **POST** /api/${模块名}/${资源名复数}

- 请求参数

  ```json
  {
      ...
  }
  ```

- 响应结果

  ```json
  {
    id: ObjectId;
  }
  ```
