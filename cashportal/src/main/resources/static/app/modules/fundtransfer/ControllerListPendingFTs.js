(function () {
    'use strict';
    angular.module('app.fundtransfer').controller('ControllerListPendingFTs', ControllerListPendingFTs);
    /* @ngInject */
    function ControllerListPendingFTs(FundTransferService,pendingFTResponse,$state, $rootScope, $http,$stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.pendingFTs = pendingFTResponse.fundTransferList;
         vm.tnxStatusCodes = FundTransferService.getTransactionStatusCodes();
       
        vm.viewFundTransfer = function(rid) {
            $state.go('app.viewInternalFT', {rid: rid});
        }
    }
})();
