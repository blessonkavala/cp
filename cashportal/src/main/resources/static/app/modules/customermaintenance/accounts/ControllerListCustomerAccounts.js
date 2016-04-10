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
        
        vm.addCustomerAccount = function(){
             $state.go('app.addCustomerAccount', {selectedOrgId: $stateParams.selectedOrgId});
        };
        
        vm.viewCustomerAccount = function (customerAccountId){
            $state.go('app.viewCustomerAccount', {customerAccountId: customerAccountId});
        };
        
        vm.editCustomerAccount = function (customerAccountId){
            $state.go('app.editCustomerAccount', {customerAccountId: customerAccountId});
        };
    }
})();