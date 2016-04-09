(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerEditCustomerPermissions', ControllerEditCustomerPermissions);
    /* @ngInject */
    function ControllerEditCustomerPermissions(OrganizationRoleService,organizationRoles,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Edit Customer';
        vm.isView = false;
        vm.isEdit = true;
        vm.isNew  = false;
        
        vm.organizationRoles = organizationRoles;
        vm.assignedRoles  =  [];
        vm.availableRoles =  [];
        
        vm.assignRole = function(){
            var tempAvailableRoles =  [];
            angular.forEach(vm.availableRoles, function(value) {
                vm.organizationRoles.assignedRoles.push(value);
                tempAvailableRoles.push(value)
            });
            vm.availableRoles = [];
            angular.forEach(tempAvailableRoles, function(role) {
                 var index=vm.organizationRoles.availableRoles.indexOf(role);
                 vm.organizationRoles.availableRoles.splice(index,1);   
            });
        };
        
        vm.removeRole = function(){
            var tempAssignedRoles =  [];
            angular.forEach(vm.assignedRoles, function(value) {
                vm.organizationRoles.availableRoles.push(value);
                tempAssignedRoles.push(value)
            });
            vm.assignedRoles  =  [];
            angular.forEach(tempAssignedRoles, function(role) {
                 var index=vm.organizationRoles.assignedRoles.indexOf(role);
                 vm.organizationRoles.assignedRoles.splice(index,1);   
            });
        };
        
        vm.updateCustomerRoles = function () {
       
        	$http.put('/orgroles/update',vm.organizationRoles).then(function(response){
        		$state.go('app.listCustomerPermissions');
        		console.log(response);
        	});
        };
        
       vm.cancel  = function() {
        	$state.go('app.listCustomerPermissions');
        };
      
    }
})();