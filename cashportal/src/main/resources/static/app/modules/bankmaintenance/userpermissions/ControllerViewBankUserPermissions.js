(function () {
    'use strict';
    angular.module('app.bankmaintenance').controller('ControllerViewBankUserPermissions', ControllerViewBankUserPermissions);
    /* @ngInject */
    function ControllerViewBankUserPermissions(userRoles,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.pageTitle="Display Bank User Permissions";
        vm.isView = true;
        vm.isEdit = false;
        vm.isNew  = false;
        
        vm.userRoles = userRoles;
        vm.assignedRoles  =  [];
        vm.availableRoles =  [];
        
        vm.cancel  = function() {
        	$state.go('app.listBankUsersPermissions',{selectedOrgId: userRoles.user.orgId});
        };
      
    }
})();