// @GENERATOR:play-routes-compiler
// @SOURCE:E:/GitRepositories/PlayFramework/play-java-seed/conf/routes
// @DATE:Wed Jun 06 02:39:47 IST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:8
  class ReverseMyController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def createAStudentFromPost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MyController.createAStudentFromPost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:9
    def createAStudent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MyController.createAStudent",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student"})
        }
      """
    )
  
    // @LINE:8
    def getAllStudents: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MyController.getAllStudents",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "students"})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseStudentController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def createStudent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.StudentController.createStudent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student"})
        }
      """
    )
  
    // @LINE:7
    def retrieveAllStudent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.StudentController.retrieveAllStudent",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "all"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
