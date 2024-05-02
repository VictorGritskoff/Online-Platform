package com.example.example;

public class CourseControllerTest {
    @Test
    public void testAddCourse() {
        CourseController courseController = new CourseController();
        Course course = new Course("Java Programming", "Intermediate");
        assertTrue(courseController.addCourse(course));
    }

    @Test
    public void testRemoveCourse() {
        CourseController courseController = new CourseController();
        Course course = new Course("Python for Beginners", "Beginner");
        courseController.addCourse(course);
        assertTrue(courseController.removeCourse(course));
    }

    @Test
    public void testGetAllCourses() {
        CourseController courseController = new CourseController();
        Course course1 = new Course("Web Development", "Advanced");
        Course course2 = new Course("Data Science", "Intermediate");
        courseController.addCourse(course1);
        courseController.addCourse(course2);
        List<Course> allCourses = courseController.getAllCourses();
        assertEquals(2, allCourses.size());
        assertTrue(allCourses.contains(course1));
        assertTrue(allCourses.contains(course2));
    }

    @Test
    public void testAddCourseWithNegativePrice() {
        CourseController courseController = new CourseController();
        Course course = new Course("JavaScript Basics", "Beginner");
        course.setPrice(-50); // Устанавливаем отрицательную цену
        12
        assertFalse(courseController.addCourse(course));
    }

    @Test
    public void testAddCourseWithInvalidDate() {
        CourseController courseController = new CourseController();
        Course course = new Course("SQL Fundamentals", "Intermediate");
        course.setStartDate(LocalDate.of(2020, 12, 31));
        assertFalse(courseController.addCourse(course));
    }

    @Test
    public void testAddCourseWithEmptyFields() {
        CourseController courseController = new CourseController();
        Course course = new Course("", "");
        assertFalse(courseController.addCourse(course));
    }
}