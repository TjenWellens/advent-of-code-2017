(defun next-index (index current-value offsets)
  (let ((result (+ index current-value)))
    (if (< result (length offsets))
      result
      nil)))

(defun next-value (current-value)
  (1+ current-value))

(defun mk-step (index offsets)
  (list index offsets))

(defun update-offset (index value offsets)
  (replace offsets (list value) :start1 index))

(defun get-offset (index offsets)
  (nth index offsets))

(defun next-step (index offsets &optional (next-value #'next-value))
  (let ((current-value (get-offset index offsets)))
    (mk-step
     (next-index index current-value offsets)
     (update-offset index (funcall next-value current-value) offsets))))

(defun count-steps (index offsets &optional (next-value #'next-value))
  (loop
    for (i offs) = (mk-step index offsets) then (next-step i offs next-value)
    while i
    counting i))

(defun file-to-offsets (path)
  (with-open-file (input path)
    (loop for line = (read input nil)
      while line collect line)))

; 396086
(defun solution ()
  (let ((index 0)
        (offsets (file-to-offsets "input.txt")))
    (count-steps index offsets)))

(defun next-value-part-2 (current-value)
  (+ current-value (if (>= current-value 3) -1 1)))

; ???
(defun solution-part-2 ()
  (let ((index 0)
        (offsets (file-to-offsets "input.txt")))
    (count-steps index offsets #'next-value-part-2)))
