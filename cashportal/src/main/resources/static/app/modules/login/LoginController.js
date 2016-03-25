(function () {
    'use strict';
    angular.module('app.login').controller('LoginController', LoginController);
    /* @ngInject */
    function LoginController($state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.login = function (user) {
       
        	$http.post('/security/login',user).then(function(response){
        		$state.go('app.dashboard');
        		console.log(response);
        	});
        	
        };
    }
})();