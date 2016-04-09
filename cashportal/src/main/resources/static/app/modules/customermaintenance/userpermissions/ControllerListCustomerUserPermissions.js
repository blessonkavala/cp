(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerListCustomerUsersPermissions', ControllerListCustomerUsersPermissions);
    /* @ngInject */
    function ControllerListCustomerUsersPermissions(UserService,$state, $rootScope, $http , $stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.users = null;
        vm.statusCodes = UserService.getStatusList();
         UserService.getUserList($stateParams.selectedOrgId).then(handleUserList);
        
        function handleUserList(users) {
            vm.users = users;
        }
        
        vm.viewCustomerUserPermissions = function (userId){
            $state.go('app.viewCustomerUserPermissions', {userId: userId});
        };
        
        vm.editCustomerUserPermissions = function (userId){
            $state.go('app.editCustomerUserPermissions', {userId: userId});
        };
    }
})();