// @GENERATOR:play-routes-compiler
// @SOURCE:E:/GitRepositories/PlayFramework/play-java-seed/conf/routes
// @DATE:Wed Jun 06 02:39:47 IST 2018


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
