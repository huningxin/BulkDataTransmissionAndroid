// Copyright (c) 2014 Intel Corporation. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

var bulkDataListener = null;

extension.setMessageListener(function(msg) {
  if (bulkDataListener instanceof Function) {
    bulkDataListener(msg);
  };
});

exports.requestBulkDataAsync = function(power, callback) {
  bulkDataListener = callback;
  extension.postMessage(power.toString());
};
