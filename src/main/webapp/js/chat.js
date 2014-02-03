var app = angular.module('chat', []);

app.controller('chatUiCtrl', function ($scope, $http) {
    $scope.post = function () {
        message = {user: "user 3", message: $scope.messageToPost};

        $http.post("http://localhost:8080/chat", message).success(function (data) {
            $scope.messages = data;
        });
    };
    $http.get("http://localhost:8080/chat").success(function (data) {
        $scope.messages = data;
    });
});