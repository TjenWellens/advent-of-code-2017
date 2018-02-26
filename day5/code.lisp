(defun next-index (index current-value offset)
  (let ((result (+ index current-value)))
    (if (< result (length offset))
      result
      nil)))

(defun next-offset (index offsets)
  (let* ((current-value (nth index offsets)))
    (list (next-index index current-value offsets)
          (replace (copy-list offsets) (list (1+ current-value)) :start1 index))))
