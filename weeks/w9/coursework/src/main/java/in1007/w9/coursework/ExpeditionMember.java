package in1007.w9.coursework;

public class ExpeditionMember {
    private String name;
    private long studentId;

    public static int member_counter = 0;

    public ExpeditionMember(String name, long studentId) {
        this.name = name;
        this.studentId = studentId;

        member_counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long newStudentId) {
        studentId = newStudentId;
    }
}
