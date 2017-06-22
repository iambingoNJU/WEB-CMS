/**
 * Created by bingo on 2017/6/22.
 */

angular.module('myApp').controller('Controller', ['$scope', 'Service', function($scope, Service) {
    var self = this;
    self.student = {id:null, name:'', major:'', grade_usual:'', grade_homework:'', grade_exam:''};
    self.students = [];

    getStudents();

    function getStudents() {
        Service.getStudents()
            .then(
                function (d) {
                    self.students = d;
                },
                function (errResponse) {
                    console.error('Error while getting students');
                }
            );
    }
    
    function addStudent(student) {
        Service.addStudent(student)
            .then(
                getStudents,
                function (errResponse) {
                    console.error('Error while adding student');
                }
            );
    }
    
    function updateStudent(student, id) {
        Service.updateStudent(student, id)
            .then(
                getStudents,
                function (errResponse) {
                    console.error('Error while updating student');
                }
            );
    }
    
    function deleteStudent(id) {
        Service.deleteStudent(id)
            .then(
                getStudents,
                function (errResponse) {
                    console.error('Error whil deleting student');
                }
            );
    }
    
    function submit() {
        if(self.student.id === null) {
            addStudent(self.student);
            console.log('Saving new student', self.student);
        } else {
            updateStudent(self.student, self.student.id);
            console.log('Student updated with id ', self.student.id);
        }
        reset();
    }
    
    function edit(id) {
        console.log('id to be edited: ', id);
        for(var i = 0; i < self.students.length; i++) {
            if(self.students[i].id === id) {
                self.student = angular.copy(self.students[i]);
                break;
            }
        }
    }
    
    function remove(id) {
        console.log('id to be removed: ', id);
        if(self.student.id === id) {
            reset();
        }
        deleteStudent(id);
    }
    
    function reset() {
        self.student = {id:null, name:'', major:'', grade_usual:'', grade_homework:'', grade_exam:''};
        //$scope.myForm.$setPristine();
    }
    
}]);