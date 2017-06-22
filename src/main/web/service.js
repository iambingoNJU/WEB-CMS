/**
 * Created by bingo on 2017/6/22.
 */

'use strict';

angular.module('myApp').factory('Service', ['$http', '$q', function($http, $q) {

    var REST_SERVICE_URI = 'http://localhost:8080/cms/student';

    var factory = {
        getStudents:    getStudents,
        addStudent:     addStudent,
        updateStudent:  updateStudent,
        deleteStudent:  deleteStudent
    };

    return factory;
    
    function getStudents() {
        var deferred = $q.defer();
        console.log("in get stuends");
        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while getting Students');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function addStudent(student) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, student)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while adding student');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
    
    function updateStudent(student, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + '/' + id, student)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while updating student');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function deleteStudent(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + '/' + id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while deleting student');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
}]);
