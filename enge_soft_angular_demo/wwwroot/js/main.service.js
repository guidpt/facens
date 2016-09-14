/**
 * Created by guidpt on 9/14/16.
 */


angular.module('appTeste').service('mainService', function ($http) {

    // this.salvarAluno = function(aluno, callback){
    //     $http({
    //         method: 'POST',
    //         url: 'https://engesoftangulardemo.firebaseio.com/alunos.json',
    //         data: aluno
    //     }).then(function successCallback(response) {
    //         callback();
    //     });
    // };
    //
    // this.listarAlunos = function(callback){
    //     $http({
    //         method: 'GET',
    //         url: 'https://engesoftangulardemo.firebaseio.com/alunos.json'
    //     }).then(function successCallback(response) {;
    //         debugger
    //         callback(respose.data);
    //     });
    // };

    this.alunos = [];

    this.salvarAluno = function (aluno, callback) {
        this.alunos.push(aluno);
        callback();
    };

    this.listarAlunos = function (callback) {
        callback(this.alunos);
    };

});
