(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerListMOPendingRecords', ControllerListMOPendingRecords);
    /* @ngInject */
    function ControllerListMOPendingRecords(pendingMORecordsResponse,$state, $rootScope, $http,$stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.pendingFTs = pendingMORecordsResponse.fundTransferList;
       
        vm.viewFundTransfer = function(rid) {
            $state.go('app.viewInternalFT', {rid: rid});
        }
    }
})();