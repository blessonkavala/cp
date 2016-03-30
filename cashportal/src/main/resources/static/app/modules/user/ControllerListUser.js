(function () {
    'use strict';
    angular.module('app.user').controller('ControllerListUser', ControllerListUser);
    /* @ngInject */
    function ControllerListUser(UserService,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.users = null;
        vm.viewUser = viewUser;
        vm.editUser = editUser;
        vm.statusCodes = UserService.getStatusList();
        var orgId = "13:0";
        UserService.getUserList(orgId).then(handleUserList);
        
        function handleUserList(users) {
            vm.users = users;
        }

        function viewUser(rid) {
            $state.go('app.viewUser', {rid: rid});
        }
        
         function editUser(rid) {
            $state.go('app.editUser', {rid: rid});
        }
      
    }
})();