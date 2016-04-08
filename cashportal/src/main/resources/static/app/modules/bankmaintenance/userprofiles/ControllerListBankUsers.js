(function () {
    'use strict';
    angular.module('app.user').controller('ControllerListBankUsers', ControllerListBankUsers);
    /* @ngInject */
    function ControllerListBankUsers(UserService,$state, $rootScope, $http,$stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.users = null;
        vm.viewUser = viewUser;
        vm.editUser = editUser;
        vm.addBankUser = addBankUser;
        vm.statusCodes = UserService.getStatusList();
        UserService.getUserList($stateParams.selectedOrgId).then(handleUserList);
        
        function handleUserList(users) {
            vm.users = users;
        }
        
        function addBankUser()
        {
            $state.go('app.addBankUser', {selectedOrgId: $stateParams.selectedOrgId});
        }

        function viewUser(rid) {
            $state.go('app.viewBankUser', {rid: rid});
        }
        
         function editUser(rid) {
            $state.go('app.editBankUser', {rid: rid});
        }
      
    }
})();