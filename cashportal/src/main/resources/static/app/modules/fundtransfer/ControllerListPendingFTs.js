(function () {
    'use strict';
    angular.module('app.fundtransfer').controller('ControllerListPendingFTs', ControllerListPendingFTs);
    /* @ngInject */
    function ControllerListPendingFTs(pendingFTs,$state, $rootScope, $http,$stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.pendingFTs = pendingFTs;
       
        function viewUser(rid) {
            $state.go('app.viewCustomerUser', {rid: rid});
        }
    }
})();