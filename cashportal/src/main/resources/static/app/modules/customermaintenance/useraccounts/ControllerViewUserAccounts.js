(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerEditUserAccounts', ControllerEditUserAccounts);
    /* @ngInject */
    function ControllerEditUserAccounts(UserService,userAccountsDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'Edit User';
        vm.isNew =  false;
        vm.isView = true;
        vm.isEdit = false;
        vm.userAccountsDetails = userAccountsDetails;

        vm.cancel = function() {
        	$state.go('app.listUserAccounts',{selectedOrgId: userAccountsDetails.customerOrgId});
        };
      
    }
})();