package controllers;

import java.util.Map;
import models.Student;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

/**
 * The controller for the home page of this application.
 * 
 * @author Philip Johnson
 */
public class Application extends Controller {

  public static Result getIndex(long id) {
    Student student = (id == 0) ? new Student() : Student.findStudent(id);
    return ok(index.render(student));
  }
  
  public static Result postIndex() {
    // Retrieve the submitted form data from the request object.
    Map<String, String[]> formValues = request().body().asFormUrlEncoded();
    // Convert the form data into a Student model instance. 
    Student student = Student.makeInstance(formValues);
    // Do something with the data.  Normally we'd save it to the database or whatever.
    System.out.println("Student is: " + student);
    // Now return something to the client. Let's just render and return the student instance.
    // If there are errors, they will be rendered in the form. 
    return ok(index.render(student));
  }
}
