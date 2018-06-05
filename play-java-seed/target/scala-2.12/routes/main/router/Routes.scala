// @GENERATOR:play-routes-compiler
// @SOURCE:E:/GitRepositories/PlayFramework/play-java-seed/conf/routes
// @DATE:Wed Jun 06 02:39:47 IST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:7
  StudentController_3: controllers.StudentController,
  // @LINE:8
  MyController_1: controllers.MyController,
  // @LINE:13
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:7
    StudentController_3: controllers.StudentController,
    // @LINE:8
    MyController_1: controllers.MyController,
    // @LINE:13
    Assets_2: controllers.Assets
  ) = this(errorHandler, HomeController_0, StudentController_3, MyController_1, Assets_2, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, StudentController_3, MyController_1, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """all""", """controllers.StudentController.retrieveAllStudent()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """students""", """controllers.MyController.getAllStudents"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """student""", """controllers.MyController.createAStudent"""),
    ("""POST""", this.prefix, """controllers.MyController.createAStudentFromPost"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """student""", """controllers.StudentController.createStudent"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_StudentController_retrieveAllStudent1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("all")))
  )
  private[this] lazy val controllers_StudentController_retrieveAllStudent1_invoker = createInvoker(
    StudentController_3.retrieveAllStudent(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StudentController",
      "retrieveAllStudent",
      Nil,
      "GET",
      this.prefix + """all""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_MyController_getAllStudents2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("students")))
  )
  private[this] lazy val controllers_MyController_getAllStudents2_invoker = createInvoker(
    MyController_1.getAllStudents,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MyController",
      "getAllStudents",
      Nil,
      "GET",
      this.prefix + """students""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_MyController_createAStudent3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("student")))
  )
  private[this] lazy val controllers_MyController_createAStudent3_invoker = createInvoker(
    MyController_1.createAStudent,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MyController",
      "createAStudent",
      Nil,
      "GET",
      this.prefix + """student""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_MyController_createAStudentFromPost4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_MyController_createAStudentFromPost4_invoker = createInvoker(
    MyController_1.createAStudentFromPost,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MyController",
      "createAStudentFromPost",
      Nil,
      "POST",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_StudentController_createStudent5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("student")))
  )
  private[this] lazy val controllers_StudentController_createStudent5_invoker = createInvoker(
    StudentController_3.createStudent,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StudentController",
      "createStudent",
      Nil,
      "POST",
      this.prefix + """student""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:7
    case controllers_StudentController_retrieveAllStudent1_route(params@_) =>
      call { 
        controllers_StudentController_retrieveAllStudent1_invoker.call(StudentController_3.retrieveAllStudent())
      }
  
    // @LINE:8
    case controllers_MyController_getAllStudents2_route(params@_) =>
      call { 
        controllers_MyController_getAllStudents2_invoker.call(MyController_1.getAllStudents)
      }
  
    // @LINE:9
    case controllers_MyController_createAStudent3_route(params@_) =>
      call { 
        controllers_MyController_createAStudent3_invoker.call(MyController_1.createAStudent)
      }
  
    // @LINE:10
    case controllers_MyController_createAStudentFromPost4_route(params@_) =>
      call { 
        controllers_MyController_createAStudentFromPost4_invoker.call(MyController_1.createAStudentFromPost)
      }
  
    // @LINE:11
    case controllers_StudentController_createStudent5_route(params@_) =>
      call { 
        controllers_StudentController_createStudent5_invoker.call(StudentController_3.createStudent)
      }
  
    // @LINE:13
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
