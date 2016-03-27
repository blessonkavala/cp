(function () {
    'use strict';
    angular.module('app.user').controller('ControllerAddUser', ControllerAddUser);
    /* @ngInject */
    function ControllerAddUser(UserService,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Add User';
        vm.isView = false;
        vm.isEdit = false;
        vm.user = {};
        vm.statusCodes = UserService.getStatusList();
        vm.saveUser = function (user) {
            //TODO:
           $http.post('/user/save',user).then(function(response){
        		$state.go('listUser');
        		console.log(response);
        	});
        	
        };
    }
})();