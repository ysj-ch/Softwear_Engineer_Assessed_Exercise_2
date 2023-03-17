classDiagram
direction BT
class Course {
  - String courseName
   String courseName
  + toString() String
  + Course() 
  + Course(String) 
}
class CourseHandler {
  + readData(JsonNode) List~Course~
  + writeData(List~Course~) ArrayNode
  + CourseHandler() 
}
class Data {
  - List~Teacher~ teachers
  - List~TeachingTask~ teachingTasks
  - List~TrainingPlan~ trainingPlans
  - List~Course~ courses
   List~Course~ courses
   List~TeachingTask~ teachingTasks
   List~TrainingPlan~ trainingPlans
   List~Teacher~ teachers
  + readJsonFile(String) void
  + writeToJsonFile(String) void
  + Data() 
}
class DataHandler~T~ {
<<Interface>>
  + writeData(List~T~) ArrayNode
  + readData(JsonNode) List~T~
}
class DataManager {
   List~Course~ courses
   List~TeachingTask~ teachingTasks
   List~TrainingPlan~ trainingPlans
   List~Teacher~ teachers
  + readJsonFile(String) void
  + addCourse(Course) void
  + addTeachingTask(TeachingTask) void
  + addTeacher(Teacher) void
  + addTrainingPlan(TrainingPlan) void
  + writeToJsonFile(String) void
  + DataManager() 
}
class Factory_TeachingTask {
  + addTeachingTask(String, String, Data) void
  + getAllTeachingTask(Data) void
  + Factory_TeachingTask() 
}
class Factory_TrainingPlan {
  + addTrainingPlan(String, String, Data) void
  + getAllTrainingPlans(Data) void
  + Factory_TrainingPlan() 
}
class IFactoryTeachingTask {
<<Interface>>
  + addTeachingTask(String, String, Data) void
  + getAllTeachingTask(Data) void
}
class IFactoryTrainingPlan {
<<Interface>>
  + getAllTrainingPlans(Data) void
  + addTrainingPlan(String, String, Data) void
}
class Main {
  + main(String[]) void
  + Main() 
}
class Manager {
<<Interface>>
  + manage(Scanner, Data, String) void
}
class Staff {
  - String name
   String name
  + toString() String
  + equals(Object) boolean
  + hashCode() int
  # canEqual(Object) boolean
  + Staff() 
}
class Teacher {
  - List~String~ course
   List~String~ course
  + hashCode() int
  + equals(Object) boolean
  + toString() String
  # canEqual(Object) boolean
  + Teacher() 
}
class TeacherHandler {
  + writeData(List~Teacher~) ArrayNode
  + readData(JsonNode) List~Teacher~
  + TeacherHandler() 
}
class TeachingTask {
  - Course course
  - String taskRequirement
   Course course
   String taskRequirement
  + toString() String
  + TeachingTask(Course, String) 
  + TeachingTask() 
}
class TeachingTaskHandler {
  + readData(JsonNode) List~TeachingTask~
  + writeData(List~TeachingTask~) ArrayNode
  + TeachingTaskHandler() 
}
class TeachingTaskManager {
  + manage(Scanner, Data, String) void
  + addTeachingRequirement(Scanner, Data, String) int
  + TeachingTaskManager(IFactoryTeachingTask) 
}
class TrainingPlan {
  - String courseName
  - String teacherName
   String courseName
   String teacherName
  + toString() String
  + TrainingPlan() 
  + TrainingPlan(String, String) 
}
class TrainingPlanHandler {
  + readData(JsonNode) List~TrainingPlan~
  + writeData(List~TrainingPlan~) ArrayNode
  + TrainingPlanHandler() 
}
class TrainingPlanManager {
  + manage(Scanner, Data, String) void
  + addTrainingPlan(Scanner, Data, String) int
  + TrainingPlanManager(IFactoryTrainingPlan) 
}

CourseHandler  ..>  Course 
CourseHandler  ..>  DataHandler~T~ 
Data "1" *--> "courses *" Course 
Data "1" *--> "courseHandler 1" DataHandler~T~ 
Data "1" *--> "teachers *" Teacher 
Data "1" *--> "teachingTasks *" TeachingTask 
Data "1" *--> "trainingPlans *" TrainingPlan 
DataManager  ..>  Course 
DataManager "1" *--> "data 1" Data 
DataManager  ..>  Teacher 
DataManager  ..>  TeachingTask 
DataManager  ..>  TrainingPlan 
Factory_TeachingTask  ..>  IFactoryTeachingTask 
Factory_TrainingPlan  ..>  IFactoryTrainingPlan 
Main "1" *--> "data 1" Data 
Main "1" *--> "teachingTaskFactory 1" IFactoryTeachingTask 
Main "1" *--> "trainingPlanFactory 1" IFactoryTrainingPlan 
Teacher  -->  Staff 
TeacherHandler  ..>  DataHandler~T~ 
TeacherHandler  ..>  Teacher 
TeachingTask "1" *--> "course 1" Course 
TeachingTaskHandler  ..>  DataHandler~T~ 
TeachingTaskHandler  ..>  TeachingTask 
TeachingTaskManager "1" *--> "teachingTaskFactory 1" IFactoryTeachingTask 
TeachingTaskManager  ..>  Manager 
TrainingPlanHandler  ..>  DataHandler~T~ 
TrainingPlanHandler  ..>  TrainingPlan 
TrainingPlanManager "1" *--> "trainingPlanFactory 1" IFactoryTrainingPlan 
TrainingPlanManager  ..>  Manager 
