(function () {
    'use strict';
    angular.module('app.login').controller('LoginController', LoginController);
    /* @ngInject */
    function LoginController($state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.errorMessages  = [];
        
        vm.login = function (user) {
       
        	$http.post('/security/login',user).then(function(response){
        		$state.go('app.dashboard');
        		console.log(response);
        	}).catch(function(error){
                console.log(error);
                vm.errorMessages = [];
                vm.errorMessages.push(error.data.message);                
            });
        };
    }
})();