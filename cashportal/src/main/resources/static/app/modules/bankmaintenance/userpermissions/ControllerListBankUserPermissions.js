(function () {
    'use strict';
    angular.module('app.bankmaintenance').controller('ControllerListBankUsersPermissions', ControllerListBankUsersPermissions);
    /* @ngInject */
    function ControllerListBankUsersPermissions(UserService,$state, $rootScope, $http , $stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.users = null;
        vm.statusCodes = UserService.getStatusList();
         UserService.getUserList($stateParams.selectedOrgId).then(handleUserList);
        
        function handleUserList(users) {
            vm.users = users;
        }
        
        vm.viewBankUserPermissions = function (userId){
            $state.go('app.viewBankUserPermissions', {userId: userId});
        };
        
        vm.editBankUserPermissions = function (userId){
            $state.go('app.editBankUserPermissions', {userId: userId});
        };
    }
})();