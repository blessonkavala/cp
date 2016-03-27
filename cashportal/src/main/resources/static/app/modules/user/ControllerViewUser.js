(function () {
    'use strict';
    angular.module('app.user').controller('ControllerViewUser', ControllerViewUser);
    /* @ngInject */
    function ControllerViewUser(UserService,userDetails,$state, $rootScope, $http) {
        /* jshint validthis: true */

        var vm = this;
        vm.formHeader = 'View User';
        vm.isView = true;
        vm.user = userDetails;
        vm.statusCodes = UserService.getStatusList();
        
         function cancel() {
        	$state.go('main.partymanagement-dashboard');
        }
      
    }
})();