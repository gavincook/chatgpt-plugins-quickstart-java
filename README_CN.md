# ChatGPT插件开发快速入门（Java版）

用Java在5分钟内启动一个todo list ChatGPT插件。如果你还没有插件开发者权限：

* 请[加入等待列表](https://openai.com/waitlist/plugins)
* 或成为Plus用户，当前已经对所有Plus用户开放

### Setup

运行插件，输入以下命令：

```bash
./gradlew bootRun
```

本地服务器运行后：

1. 打开https://chat.openai.com
2. 在模型下拉菜单中选择“Plugins”（注意，如果你在这里看不到它，你还没有权限）
3. 选择`Plugin store`
4. 选择`Develop your own plugin`
5. 输入`http://localhost:8080`，因为这是本地服务器运行的URL，然后选择“Find manifest file”。

插件现在应该已经安装并启用了！你可以从一个问题开始，比如“我的待办事项有哪些”，也可以尝试添加一些待办事项！