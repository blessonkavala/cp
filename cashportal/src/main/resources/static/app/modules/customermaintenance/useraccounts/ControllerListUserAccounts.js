(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerListUserAccounts', ControllerListUserAccounts);
    /* @ngInject */
    function ControllerListUserAccounts(UserService,$state, $rootScope, $http , $stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.users = null;
        vm.statusCodes = UserService.getStatusList();
        UserService.getUserList($stateParams.selectedOrgId).then(handleUserList);
        
        function handleUserList(users) {
            vm.users = users;
        }
        
        vm.viewUserAccounts = function (userId){
            $state.go('app.viewUserAccounts', {userId: userId});
        };
        
        vm.editUserAccounts = function (userId){
            $state.go('app.editUserAccounts', {userId: userId});
        };
    }
})();