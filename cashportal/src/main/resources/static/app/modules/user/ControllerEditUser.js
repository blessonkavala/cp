(function () {
    'use strict';
    angular.module('app.user').controller('ControllerEditUser', ControllerEditUser);
    /* @ngInject */
    function ControllerEditUser(UserService,userDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Edit User';
        vm.isView = false;
        vm.isEdit = true;
        vm.user = userDetails;
        vm.statusCodes = UserService.getStatusList();
        
        vm.updateUser = function (user) {
       
        	$http.put('/user/update',user).then(function(response){
        		$state.go('app.listUser');
        		console.log(response);
        	});
        	
        };
        
         function cancel() {
        	$state.go('main.partymanagement-dashboard');
        }
      
    }
})();