// @GENERATOR:play-routes-compiler
// @SOURCE:E:/GitRepositories/PlayFramework/play-java-seed/conf/routes
// @DATE:Wed Jun 06 02:39:47 IST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:8
  class ReverseMyController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def createAStudentFromPost(): Call = {
      
      Call("POST", _prefix)
    }
  
    // @LINE:9
    def createAStudent(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "student")
    }
  
    // @LINE:8
    def getAllStudents(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "students")
    }
  
  }

  // @LINE:7
  class ReverseStudentController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def createStudent(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "student")
    }
  
    // @LINE:7
    def retrieveAllStudent(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "all")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:13
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
