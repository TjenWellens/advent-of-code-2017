(defun next-index (index current-value offset)
  (let ((result (+ index current-value)))
    (if (< result (length offset))
      result
      nil)))

(defun next-value (current-value)
  (1+ current-value))

(defun next-offset (index offsets &optional (next-value #'next-value))
  (let* ((current-value (nth index offsets)))
    (list (next-index index current-value offsets)
          (replace (copy-list offsets) (list (funcall next-value current-value)) :start1 index))))

(defun count-steps (index offsets &optional (next-value #'next-value))
  (loop
    for (i offs) = (list index offsets) then (next-offset i offs next-value)
    while i
    counting i
    do (print i)))

(defun file-to-list (path)
  (with-open-file (input path)
    (loop for line = (read input nil)
      while line collect line)))

; 396086
(defun solution ()
  (let ((index 0)
        (offsets (file-to-list "input.txt")))
    (count-steps index offsets)))
