/**
 * Created by guidpt on 9/14/16.
 */

angular.module('appTeste').controller('mainCtrl', function ($scope, mainService) {

    $scope.alunos = [];
    $scope.title = "Demo - Engenharia de Software";

    var callBackSaveSuccess = function(){
        mainService.listarAlunos(callBackListSuccess);
    };

    var callBackListSuccess = function(data){
        $scope.alunos = data;
    };

    $scope.onGravar = function(form){
        if(form.$valid) {
            mainService.salvarAluno(angular.copy($scope.model), callBackSaveSuccess);

            $scope.model = {ra: '', nome: ''};
            form.$setPristine();
        }
    };
});

