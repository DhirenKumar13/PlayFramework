// @GENERATOR:play-routes-compiler
// @SOURCE:E:/GitRepositories/PlayFramework/play-java-starter-for-rabbitmq/conf/routes
// @DATE:Thu Jun 07 03:05:37 IST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
