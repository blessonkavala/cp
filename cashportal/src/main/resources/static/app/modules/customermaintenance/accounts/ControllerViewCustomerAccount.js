(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerViewCustomerAccount', ControllerViewCustomerAccount);
    /* @ngInject */
    function ControllerViewCustomerAccount(UserService,customerAccount,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Edit User';
        vm.isNew =  false;
        vm.isView = true;
        vm.isEdit = false;
        vm.customerAccount = customerAccount;
        
        vm.cancel = function() {
        	$state.go('app.listCustomerAccounts',{selectedOrgId: customerAccount.customerOrgId});
        };
      
    }
})();