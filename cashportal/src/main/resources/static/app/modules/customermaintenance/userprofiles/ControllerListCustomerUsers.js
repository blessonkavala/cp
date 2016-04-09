(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerListCustomerUsers', ControllerListCustomerUsers);
    /* @ngInject */
    function ControllerListCustomerUsers(UserService,$state, $rootScope, $http,$stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.users = null;
        vm.viewUser = viewUser;
        vm.editUser = editUser;
        vm.addCustomerUser = addCustomerUser;
        vm.statusCodes = UserService.getStatusList();
        UserService.getUserList($stateParams.selectedOrgId).then(handleUserList);
        
        function handleUserList(users) {
            vm.users = users;
        }
        
        function addCustomerUser()
        {
            $state.go('app.addCustomerUser', {selectedOrgId: $stateParams.selectedOrgId});
        }

        function viewUser(rid) {
            $state.go('app.viewCustomerUser', {rid: rid});
        }
        
         function editUser(rid) {
            $state.go('app.editCustomerUser', {rid: rid});
        }
      
    }
})();