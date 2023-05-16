# ChatGPT plugins quick start in Java version

[中文说明](/README_CN.md)

Get a todo list ChatGPT plugin up and running in under 5 minutes using Java. If you do not already have plugin
developer access:

* please [join the waitlist](https://openai.com/waitlist/plugins)
* or become a Plus user, it is currently open to all Plus users

### Setup

To run the plugin, enter the following command:

```bash
./gradlew bootRun
```

Once the local server is running:

1. Navigate to https://chat.openai.com.
2. In the Model drop down, select "Plugins" (note, if you don't see it there, you don't have access yet).
3. Select "Plugin store"
4. Select "Develop your own plugin"
5. Enter in `http://localhost:8080` since this is the URL the server is running on locally, then select "Find manifest
   file".

The plugin should now be installed and enabled! You can start with a question like "What is on my todo list" and then
try adding something to it as well!

### Authentication

ChatGPT plugins support four authentication methods:

* `None` :
  No authentication required, Current example is using this method.
* `Service level`:
  Authentication is required for the whole service, you can set the authentication token in
  the`application.yaml` file and verify token from openai plugin install ui in the `ai-plugin.json` file as shown in
  [service level authentication example](https://github.com/gavincook/chatgpt-plugins-quickstart-java/tree/service_http_auth)
  .
* `User level`:
  Authentication is required for each user, user can set the authentication token when install the plugin.
* `OAuth`
  Authentication is required for each user, user can use OAuth to get the authentication token when install the plugin.