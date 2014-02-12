var app = angular.module('chat', []);

app.controller('chatUiCtrl', function ($scope, $http) {

    var socket = new SockJS('/chat/messages');
    stompClient = Stomp.over(socket);

    stompClient.connect('', '', function() {
        stompClient.subscribe('/topic/messages', function(data){
            $scope.messages = JSON.parse(data.body);
            $scope.$apply();
        });
    });

    $scope.post = function () {
        message = {user: "user 3", message: $scope.messageToPost};
        stompClient.send("/app/chat/messages", {}, JSON.stringify(message));
    };

    $http.get("/chat").success(function (data) {
        $scope.messages = data;
    });
});