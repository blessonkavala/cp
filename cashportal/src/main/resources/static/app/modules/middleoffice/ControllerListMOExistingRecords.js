(function () {
    'use strict';
    angular.module('app.customermaintenance').controller('ControllerListMOExistingRecords', ControllerListMOExistingRecords);
    /* @ngInject */
    function ControllerListMOExistingRecords(existingMORecordsResponse,$state, $rootScope, $http,$stateParams) {
        /* jshint validthis: true */

        var vm = this;
        vm.existingFTs = existingMORecordsResponse.fundTransferList;
       
        vm.viewFundTransfer = function(rid) {
            $state.go('app.viewInternalFT', {rid: rid});
        }
    }
})();