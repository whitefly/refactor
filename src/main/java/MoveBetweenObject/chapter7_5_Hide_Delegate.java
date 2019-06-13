package MoveBetweenObject;

public class chapter7_5_Hide_Delegate {

    class Person {
        private Department department;


        public Department getDepartment() {
            return department;
        }

        public String getManager() {
            return department.getManager();
        }
    }

    class Department {
        private String departmentCode;
        private String Manager;

        public String getDepartmentCode() {
            return departmentCode;
        }

        public String getManager() {
            return Manager;
        }
    }


    public void main(String[] args) {
        //重构前,用户想知道person的经理是谁,需要先得到Department类,然后获取经理名,
        //无形中加重了用户的调用负担
        Person person = new Person();
        person.getDepartment().getManager();


        //重构后:给person类加一个getManager()的委托函数,用户可以直接调用,而不需要知道内部关系
        person.getManager();
    }
}
