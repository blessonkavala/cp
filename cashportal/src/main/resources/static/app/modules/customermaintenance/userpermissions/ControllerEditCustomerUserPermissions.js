(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerEditCustomerUserPermissions', ControllerEditCustomerUserPermissions);
    /* @ngInject */
    function ControllerEditCustomerUserPermissions(userRoles,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Edit Customer User Permissions';
        vm.isView = false;
        vm.isEdit = true;
        vm.isNew  = false;
        
        vm.userRoles = userRoles;
        vm.assignedRoles  =  [];
        vm.availableRoles =  [];
        
        vm.assignRole = function(){
            var tempAvailableRoles =  [];
            angular.forEach(vm.availableRoles, function(value) {
                vm.userRoles.assignedRoles.push(value);
                tempAvailableRoles.push(value)
            });
            vm.availableRoles = [];
            angular.forEach(tempAvailableRoles, function(role) {
                 var index=vm.userRoles.availableRoles.indexOf(role);
                 vm.userRoles.availableRoles.splice(index,1);   
            });
        };
        
        vm.removeRole = function(){
            var tempAssignedRoles =  [];
            angular.forEach(vm.assignedRoles, function(value) {
                vm.userRoles.availableRoles.push(value);
                tempAssignedRoles.push(value)
            });
            vm.assignedRoles  =  [];
            angular.forEach(tempAssignedRoles, function(role) {
                 var index=vm.userRoles.assignedRoles.indexOf(role);
                 vm.userRoles.assignedRoles.splice(index,1);   
            });
        };
        
        vm.updateCustomerUserRoles = function () {
       	$http.put('/userroles/update',vm.userRoles).then(function(response){
        	    $state.go('app.listCustomerUsersPermissions',{selectedOrgId: userRoles.user.orgId});
                console.log(response);
        	});
        };
        
       vm.cancel  = function() {
        	$state.go('app.listCustomerUsersPermissions',{selectedOrgId: userRoles.user.orgId});
        };
      
    }
})();