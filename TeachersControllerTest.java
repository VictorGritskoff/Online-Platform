package com.example.example;

public class TeachersControllerTest {
    @Test
    public void testAddTeacher() {
        TeachersController teachersController = new TeachersController();
        Teacher teacher = new Teacher("John Doe", "Mathematics");
        assertTrue(teachersController.addTeacher(teacher));
    }
11
    @Test
    public void testRemoveTeacher() {
        TeachersController teachersController = new TeachersController();
        Teacher teacher = new Teacher("Jane Smith", "English");
        teachersController.addTeacher(teacher);
        assertTrue(teachersController.removeTeacher(teacher));
    }
    @Test
    public void testGetAllTeachers() {
        TeachersController teachersController = new TeachersController();
        Teacher teacher1 = new Teacher("John Doe", "Mathematics");
        Teacher teacher2 = new Teacher("Jane Smith", "English");
        teachersController.addTeacher(teacher1);
        teachersController.addTeacher(teacher2);
        List<Teacher> allTeachers = teachersController.getAllTeachers();
        assertEquals(2, allTeachers.size());
        assertTrue(allTeachers.contains(teacher1));
        assertTrue(allTeachers.contains(teacher2));
    }
}