import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IUserProfile } from 'app/shared/model/user-profile.model';
import { getEntities as getUserProfiles } from 'app/entities/user-profile/user-profile.reducer';
import { IChannel } from 'app/shared/model/channel.model';
import { getEntity, updateEntity, createEntity, reset } from './channel.reducer';

export const ChannelUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const userProfiles = useAppSelector(state => state.userProfile.entities);
  const channelEntity = useAppSelector(state => state.channel.entity);
  const loading = useAppSelector(state => state.channel.loading);
  const updating = useAppSelector(state => state.channel.updating);
  const updateSuccess = useAppSelector(state => state.channel.updateSuccess);

  const handleClose = () => {
    navigate('/channel');
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }

    dispatch(getUserProfiles({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    values.updatedAt = convertDateTimeToServer(values.updatedAt);

    const entity = {
      ...channelEntity,
      ...values,
      userProfile: userProfiles.find(it => it.id.toString() === values.userProfile.toString()),
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {
          updatedAt: displayDefaultDateTime(),
        }
      : {
          ...channelEntity,
          updatedAt: convertDateTimeFromServer(channelEntity.updatedAt),
          userProfile: channelEntity?.userProfile?.id,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="jiveApp.channel.home.createOrEditLabel" data-cy="ChannelCreateUpdateHeading">
            <Translate contentKey="jiveApp.channel.home.createOrEditLabel">Create or edit a Channel</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="channel-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField label={translate('jiveApp.channel.name')} id="channel-name" name="name" data-cy="name" type="text" />
              <ValidatedField
                label={translate('jiveApp.channel.description')}
                id="channel-description"
                name="description"
                data-cy="description"
                type="text"
              />
              <ValidatedField
                label={translate('jiveApp.channel.updatedAt')}
                id="channel-updatedAt"
                name="updatedAt"
                data-cy="updatedAt"
                type="datetime-local"
                placeholder="YYYY-MM-DD HH:mm"
              />
              <ValidatedField
                id="channel-userProfile"
                name="userProfile"
                data-cy="userProfile"
                label={translate('jiveApp.channel.userProfile')}
                type="select"
              >
                <option value="" key="0" />
                {userProfiles
                  ? userProfiles.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/channel" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default ChannelUpdate;
