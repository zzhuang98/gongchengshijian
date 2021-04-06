package six.daoyun.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;


@Entity
@Table(name="course")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id @GeneratedValue @Column(name = "pk_course_id")
    private long id;
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "course_name")
    private String courseName;
    public String getCourseName() {
        return this.courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    private User teacher;
    @OneToOne
    public User getTeacher() {
        return this.teacher;
    }
    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    private Collection<User> students;
    @ManyToMany
    public Collection<User> getStudents() {
        return this.students;
    }
    public void setStudents(Collection<User> students) {
        this.students = students;
    }

    private Collection<CheckInTask> checkInTask;
    @OneToMany(mappedBy = "course")
    public Collection<CheckInTask> getCheckInTask() {
        return this.checkInTask;
    }
    public void setCheckInTask(Collection<CheckInTask> checkInTask) {
        this.checkInTask = checkInTask;
    }

    private Collection<CourseTask> tasks;
    @OneToMany(mappedBy = "course")
    public Collection<CourseTask> getTasks() {
        return this.tasks;
    }
    public void setTasks(Collection<CourseTask> tasks) {
        this.tasks = tasks;
    }
}

