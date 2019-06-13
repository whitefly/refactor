package MoveBetweenObject;

public class chapter7_3_Extract_Class {

    class Person {
        private String name;
        private String officeAreaCode;
        private String officeNumber;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOfficeAreaCode() {
            return officeAreaCode;
        }

        public void setOfficeAreaCode(String officeAreaCode) {
            this.officeAreaCode = officeAreaCode;
        }

        public String getOfficeNumber() {
            return officeNumber;
        }

        public void setOfficeNumber(String officeNumber) {
            this.officeNumber = officeNumber;
        }
    }


    //--------重构理由, Person类的电话完全可以分离出来-------
    class OfficePhone {
        private String officeAreaCode;
        private String officeNumber;

        public String getOfficeAreaCode() {
            return officeAreaCode;
        }

        public void setOfficeAreaCode(String officeAreaCode) {
            this.officeAreaCode = officeAreaCode;
        }

        public String getOfficeNumber() {
            return officeNumber;
        }

        public void setOfficeNumber(String officeNumber) {
            this.officeNumber = officeNumber;
        }
    }

    class Person2 {
        private String name;
        private OfficePhone officePhone;

        public Person2(String name, OfficePhone officePhone) {
            this.name = name;
            this.officePhone = officePhone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOfficeAreaCode() {
            return officePhone.getOfficeAreaCode();
        }

        public void setOfficeAreaCode(String officeAreaCode) {
            officePhone.setOfficeAreaCode(officeAreaCode);
        }

        public String getOfficeNumber() {
            return officePhone.getOfficeNumber();
        }

        public void setOfficeNumber(String officeNumber) {
            officePhone.setOfficeNumber(officeNumber);
        }
    }
}
