(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerListCustomerAccounts', ControllerListCustomerAccounts);
    /* @ngInject */
    function ControllerListCustomerAccounts(AccountService,$state, $rootScope, $http , $stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.customerAccounts = null;
        AccountService.getCustomerAccounts($stateParams.selectedOrgId).then(handleCustomerAccounts);
        
        function handleCustomerAccounts(customerAccounts) {
            vm.customerAccounts = customerAccounts;
        }
        
        vm.viewCustomerAccount = function (accountId){
            $state.go('app.viewCustomerAccount', {accountId: accountId});
        };
        
        vm.editCustomerAccount = function (orgId){
            $state.go('app.editCustomerAccount', {accountId: accountId});
        };
    }
})();